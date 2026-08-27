class Solution:
    def restoreIpAddresses(self, s: str) -> list[str]:
        result = []
        
        if len(s) < 4 or len(s) > 12:
            return result
        
        def backtrack(index: int, dots: int, path: list[str]):
            if dots == 4:
                if index == len(s):
                    result.append(".".join(path))
                return
            
            remaining_digits = len(s) - index
            remaining_dots = 4 - dots
            if remaining_digits < remaining_dots or remaining_digits > remaining_dots * 3:
                return

            for length in range(1, 4):
                if index + length > len(s):
                    break
                
                segment = s[index : index + length]
                
                if len(segment) > 1 and segment[0] == '0':
                    continue
                
                if int(segment) > 255:
                    continue
                
                path.append(segment)
                backtrack(index + length, dots + 1, path)
                path.pop()

        backtrack(0, 0, [])
        return result
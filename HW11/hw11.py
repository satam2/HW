from collections import deque

class pySol():
    def floodFill(self, image, sr, sc, color):
        oldColor = image[sr][sc]
        if oldColor is color:
            return image
        
        w = len(image)
        l = len(image[0])
        queue = deque([(sr,sc)])
        
        while queue:
            r,c = queue.popleft()
            if image[r][c] is oldColor:
                image[r][c] = color
                if(r>0):
                    queue.append((r-1,c))
                if(r<w-1):
                    queue.append((r+1,c))
                if(c>0):
                    queue.append((r,c-1))
                if(c<l-1):
                    queue.append((r,c+1))
        
        return image
    
# sol = pySol()
# image = [[1, 1, 1],[1, 1, 0],[1, 0, 1]]
# for row in image:
#     print(row)
# print("\n")
# sol.floodFill(image,1,1,2)
# for row in image:
#     print(row)

        

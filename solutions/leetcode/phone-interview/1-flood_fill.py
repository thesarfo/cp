class Solution(object):
    def floodFill(self, image, sr, sc, color):
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        def dfs(x, y, original_color):
            if x < 0 or x >= len(image) or y < 0 or y >= len(image[0]) or image[x][y] != original_color:
                return
            image[x][y] = color
            for dx, dy in directions:
                dfs(x + dx, y + dy, original_color)
        
        original_color = image[sr][sc]
        if original_color != color:
            dfs(sr, sc, original_color)
        
        return image
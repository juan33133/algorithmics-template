class Prim: 
    def __init__(self, nodes, graph):
        self.N = nodes
        self.graph = graph

    def printMST(self, parent):
        total_cost = sum(self.graph[i][parent[i]] for i in range(1,self.N))
        print("COSTE TOTAL ÓPTIMO =", total_cost)
        print("*********************")
        print("ARISTAS SELECCIONADAS=")
        for i in range (self.N -1):
            print(f"ARISTA NUMERO {i} :  DESDE NODO= {parent[i]}  HASTA NODO {i} *** COSTE= {self.graph[i][parent[i]]}")


    def minPath(self, path, mstSet):
        min_val = float('inf')
        min_index = -1

        for v in range(self.N ):
            if path[v] < min_val and not mstSet[v]:
                min_val = path[v]
                min_index = v

        return min_index

    def prim(self):
        path = [float('inf')] * self.N
        parent = [None] * self.N
        path[0] = 0
        mstSet = [False] * self.N
        parent[0] = -1

        for _ in range(self.N -1):
            u = self.minPath(path, mstSet)
            mstSet[u] = True

            for v in range(self.N -1):
                if self.graph[u][v] > 0 and not mstSet[v] and path[v] > self.graph[u][v]:
                    path[v] = self.graph[u][v]
                    parent[v] = u

        self.printMST(parent)
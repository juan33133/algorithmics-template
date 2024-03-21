from Prim import Prim
from Helper import triangularMatrixFromFile
import time

graph_sizes = [4, 8, 16, 32, 64, 128, 256]

for size in graph_sizes:
    print(f'-------------------------{size}-------------------------')
    graph = triangularMatrixFromFile(f's4/inputs/graph{size}.txt')
    nodes = size-1
    
    prim_instance = Prim(nodes, graph)

    start_time = time.time()
    prim_instance.prim()
    end_time = time.time()
    

    print(f"Graph size: {num_vertices}, Execution time: {end_time - start_time} seconds")
d = {'k1': 1, 'k2': 2, 'k3': 3}
for k in d.keys():
    v = d[k]
    d[v] = k
    del d[k]
print(d)

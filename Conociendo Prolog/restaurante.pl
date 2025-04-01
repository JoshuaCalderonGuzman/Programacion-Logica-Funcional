entrada(antipasto).
entrada(sopa).
entrada(quesos).
carne(milanesa).
carne(bife_de_chorizo).
carne(pollo_asado).
pescado(congrio).
pescado(pejerey).
postre(flan).
postre(helado).
postre(fruta).
plato_principal(P) :- carne(P).
plato_principal(P) :- pescado(P).
comida(E, P, D) :- entrada(E), plato_principal(P), postre(D).

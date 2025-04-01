entrada(antipasto).
entrada(sopa).
entrada(quesos).
carne(milanesa).
pescado(pejerrey).
plato_principal(P) :- carne(P).
plato_principal(P) :- pescado(P).
postre(flan).
postre(helado).
postre(torta).
comida(E, P, D) :- entrada(E), plato_principal(P), postre(D).

%Definimoslascalorias
calorias(antipasto, 200).
calorias(sopa, 150).
calorias(quesos, 300).
calorias(milanesa, 500).
calorias(pejerrey, 400).
calorias(flan, 250).
calorias(helado, 350).
calorias(torta, 450).

% Calcular el valor calorico de una comida
valor(E, P, D, V) :-
    calorias(E, X),
    calorias(P, Y),
    calorias(D, Z),
    V is X + Y + Z.
%Comida equilibrada
comida_equilibrada(E, P, D) :-
    comida(E,P,D),
    valor(E, P, D, V),
    V =< 800.

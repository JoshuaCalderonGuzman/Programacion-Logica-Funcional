inicio :-
    write('Ingrese el n�mero inicial de botellas: '),
    read(N),
    nl,
    cancion(N).
cancion(0) :-
    write('No m�s botellas de cerveza en la pared, no m�s botellas de cerveza.'), nl,
    write('Ve a la tienda y compra m�s'), nl.
cancion(N) :-
    N > 0,
    write(N), write(' botellas de cerveza en la pared, '), write(N),
    write(' botellas de cerveza.'), nl,
    write('Toma una y p�sala, '),
    NuevoN is N - 1,
    write(NuevoN),
    write(' botellas de cerveza en la pared.'), nl,
    cancion(NuevoN).

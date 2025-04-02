inicio :-
    write('Ingrese el número inicial de botellas: '),
    read(N),
    nl,
    cancion(N).
cancion(0) :-
    write('No más botellas de cerveza en la pared, no más botellas de cerveza.'), nl,
    write('Ve a la tienda y compra más'), nl.
cancion(N) :-
    N > 0,
    write(N), write(' botellas de cerveza en la pared, '), write(N),
    write(' botellas de cerveza.'), nl,
    write('Toma una y pásala, '),
    NuevoN is N - 1,
    write(NuevoN),
    write(' botellas de cerveza en la pared.'), nl,
    cancion(NuevoN).

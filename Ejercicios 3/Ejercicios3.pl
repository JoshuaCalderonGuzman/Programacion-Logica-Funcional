%Ejercicio 1 : Planificador de gastos
transporte(roma, 20000).
transporte(londres, 25000).
transporte(tunez, 15000).
alojamiento(hotel, roma, 25000).
alojamiento(hotel, londres, 15000).
alojamiento(hotel, tunez, 10000).
alojamiento(hostal, roma, 15000).
alojamiento(hostal, londres, 10000).
alojamiento(hostal, tunez, 8000).
alojamiento(camping, roma, 10000).
alojamiento(camping, londres, 5000).
alojamiento(camping, tunez, 5000).
costo_viaje(Destino, TipoAlojamiento, Dias, CostoTotal) :-
    transporte(Destino, CostoTransporte),
    alojamiento(TipoAlojamiento, Destino, CostoPorDia),
    CostoHospedaje is Dias * CostoPorDia,
    CostoTotal is CostoTransporte + CostoHospedaje.

%Ejercicio 2: Horoscopo
diasMes(1, 31).
diasMes(2, 28).
diasMes(3, 31).
diasMes(4, 30).
diasMes(5, 31).
diasMes(6, 30).
diasMes(7, 31).
diasMes(8, 31).
diasMes(9, 30).
diasMes(10, 31).
diasMes(11, 30).
diasMes(12, 31).



diaValido(Dia, Mes) :-
    diasMes(Mes, MaxDias),
    Dia =< MaxDias.

horoscopo(aries, 21, 3, 21, 4).
horoscopo(tauro, 21, 4, 21, 5).
horoscopo(geminis, 21, 5, 21, 6).
horoscopo(cancer, 21, 6, 21, 7).
horoscopo(leo, 21, 7, 21, 8).
horoscopo(virgo, 21, 8, 21, 9).
horoscopo(libra, 21, 9, 21, 10).
horoscopo(escorpio, 21, 10, 21, 11).
horoscopo(sagitario, 21, 11, 21, 12).
horoscopo(capricornio, 21, 12, 21, 1).
horoscopo(acuario, 21, 1, 21, 2).
horoscopo(piscis, 21, 2, 21, 3).

signo(Dia, Mes, Signo) :-
    horoscopo(Signo, D1, M1, D2, M2),
    diaValido(Dia, Mes),
    ((Mes = M1, Dia >= D1) ; (Mes = M2, Dia =< D2)).

%Ejercicio 3: Diagnostico de enfermedades


tiene_sintoma(alicia,cansancio).
sintoma_de(fiebre, gripe).
sintoma_de(tos,gripe).
sintoma_de(cansancio,anemia).
elimina(vitaminas, cansancio).
elimina(aspirinas, fiebre).
elimina(jarabe,tos).
recetar_a(X,Y) :-enfermo_de(Y,A),alivia(X,A).
alivia(X, Y) :-elimina(X,A),sintoma_de(A, Y).
enfermo_de(manuel,gripe).
enfermo_de(X,Y):-tiene_sintoma(X,Z),sintoma_de(Z,Y).


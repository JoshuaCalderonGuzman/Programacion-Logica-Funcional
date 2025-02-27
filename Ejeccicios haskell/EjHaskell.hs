import GHC.Base (VecElem(Int16ElemRep))
-- Sumar elementos de una lista
sumarLista :: [Int] -> Int
sumarLista = sum

-- Factorial
factorial :: Int -> Int
factorial  0 = 1
factorial n = n * factorial (n - 1)

-- Numeros pares
numPares :: Int -> [Int]
numPares n = [x | x <- [0..n], even x]

-- Longitud de una cadena

logCadena :: String -> Int
logCadena = length

--Reverso de una lista
revLista :: [a] -> [a]
revLista = reverse

--Duplicar elementos
duplElementos :: [Int] -> [Int]
duplElementos = map (* 2)

-- Filtrar elemtos pares
filtPares :: [Int] -> [Int]
filtPares = filter even

--Fibonacci
fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n - 1) + fibonacci (n - 2)

--Divisores de un numero
divisor :: Int -> [Int]
divisor n = [x | x <- [1..n], n `mod` x == 0]

--Palindromo

palindromo :: String -> Bool
palindromo str = str == reverse str

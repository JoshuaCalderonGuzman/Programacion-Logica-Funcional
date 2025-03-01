import Data.List
--1)===========================================================================================================
-- Funcion para aplicar un descuento a un precio
aplicarDescuento :: Float -> Float -> Float
aplicarDescuento precio descuento = precio * (1 - descuento / 100)

-- Funcion para aplicar el IVA a un precio
aplicarIVA :: Float -> Float -> Float
aplicarIVA precio iva = precio * (1 + iva / 100)

-- Funcion que recibe un diccionario de precios y porcentajes, y una funcion (descuento o IVA)
calcularPrecioFinal :: [(Float, Float)] -> (Float -> Float -> Float) -> Float
calcularPrecioFinal cesta funcion = sum [funcion precio porcentaje | (precio, porcentaje) <- cesta]

--2)==========================================================================================================
--Funcion
duplicar :: Int -> Int
duplicar x = x * 2
-- Funcion que aplica una funcion a cada elemento de una lista
aplicarFuncionLista :: (a -> b) -> [a] -> [b]
aplicarFuncionLista = map
--3)==========================================================================================================
-- Funcion que recibe una frase y devuelve un diccionario con las palabras y su longitud
longitudPalabras :: String -> [(String, Int)]
longitudPalabras frase = [(palabra, length palabra) | palabra <- words frase]
--4)===========================================================================================================
-- Función que recibe una lista de materias y calificaciones, y devuelve otro con las materias y su desempeño
calificarMaterias :: [(String, Float)] -> [(String, String)]
calificarMaterias notas = [(asignatura, calificacion nota) | (asignatura, nota) <- notas]
  where
    calificacion nota
      | nota >= 95  = "Excelente"
      | nota >= 85  = "Notable"
      | nota >= 75  = "Bueno"
      | nota >= 70  = "Suficiente"
      | otherwise   = "Desempeno insuficiente"
--5)============================================================================================================
-- Funcion que calcula el modulo de un vector
moduloVector :: [Float] -> Float
moduloVector vector = sqrt (foldl' (\acc x -> acc + x^2) 0 vector)
--6)============================================================================================================
-- Función para calcular la media de una lista de números
media :: [Double] -> Double
media xs = sum xs / genericLength xs

-- Función para calcular la desviación típica de una lista de números
desviacionTipica :: [Double] -> Double
desviacionTipica xs = sqrt (sum [(x - media xs)^2 | x <- xs] / genericLength xs)

-- Función para calcular la puntuación típica de un valor
puntuacionTipica :: [Double] -> Double -> Double
puntuacionTipica xs x = (x - media xs) / desviacionTipica xs

-- Función para encontrar los valores atípicos
valoresAtipicos :: [Double] -> [Double]
valoresAtipicos xs = [x | x <- xs, abs (puntuacionTipica xs x) > 3]



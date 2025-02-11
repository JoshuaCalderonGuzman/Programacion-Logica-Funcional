fizzbuzz :: Int -> String
fizzbuzz n
    | n `mod` 3 == 0 && n `mod` 5 == 0 = "FizzBuzz!"
    | n `mod` 3 == 0 = "Buzz!"
    | n `mod` 5 == 0 = "Fizz!"
    | otherwise = numeroPalabra n

lessThan20 :: Int -> String
lessThan20 n
    | n > 0 && n < 20 =
        let answers = words "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen"
        in answers !! (n - 1)

tens :: Int -> String
tens n
    | n >= 2 && n <= 9 =
        let answers = words "twenty thirty forty fifty sixty seventy eighty ninety"
        in answers !! (n - 2)


numeroPalabra :: Int -> String
numeroPalabra n
    | n >= 1 && n < 20 = lessThan20 n
    | n >= 20 && n < 100 = tens (n `div` 10) ++ " " ++ lessThan20 (n `mod` 10)
    | n == 100 = "one hundred"
main :: IO ()
main = do
    putStrLn (fizzbuzz 8)

 

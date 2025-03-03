{-# OPTIONS_GHC -Wno-unused-do-bind #-}
{-# OPTIONS_GHC -Wno-missing-signatures #-}
-- Joshua Calderon Guzman, Gordillo Aguilar Francisco Javier, Quintino Aguilera César Isaac

import Graphics.UI.Threepenny hiding (new, label)

main :: IO ()
main = startGUI config gui

gui :: Window -> UI ()
gui w =
  do getBody w #+ [h1 # set text "Hello world!"]
               # set style [("background","lightskyblue")]
     disp <- mkElement "input" # set value "0"
     getBody w #+ [element disp]
     let addButton :: String -> (Int->Int) -> UI ()
         addButton label f =
           do btn <- mkElement "button" # set text label
              getBody w #+ [element btn]
              on click btn (\ _ -> do s <- get value disp
                                      let old = read s :: Int
                                          new = f old
                                      set' value (show new) disp)
     addButton "+1" (+1)
     addButton "-1" (subtract 1)
     addButton "*2" (*2)
     addButton "0" (const 0)
     return ()

config = defaultConfig { jsLog= \ _ -> return ()}
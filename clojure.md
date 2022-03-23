inline functions

- #(str "Hello, " % "!")

same as 

- (fn [x] (str "Hello, " x "!"))

------------------------------------

The map function takes two arguments: a function (f) and a sequence (s). Map returns a new sequence consisting of the result of applying f to each item of s. Do not confuse the map function with the map data structure.

(= [6 7 8] (map #(+ % 5) '(1 2 3)))

---------------------------------------

The filter function takes two arguments: a predicate function (f) and a sequence (s). Filter returns a new sequence consisting of all the items of s for which (f item) returns true.

(= [6 7] (filter #(> % 5) '(3 4 5 6 7)))

---------------------------------

(-> 3 (- 2)) ; It means (- 3 2)
=> 1

(->> 3 (- 2)) ; It means (- 2 3)
=> -1

---------------------------------


@some-value is used to get the value of atom

--------------------------------

clojure resources
https://www.youtube.com/watch?v=OUZZKtypink


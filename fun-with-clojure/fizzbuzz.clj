
(defn multiple-of-3 
[x]
(if (= (mod x 3) 0)
true
false))

(defn multiple-of-5
[x]
(if (= (mod x 5) 0)
true
false))


(defn fizzbuzz 
[x]
( cond (and 
	(multiple-of-3 x)
	(multiple-of-5 x)) (prn x "fizzbuzz")
(multiple-of-3 x) (prn x "fizz")
(multiple-of-5 x) (prn x "buzz")))


(loop [x 1]
(when (< x 101)
(fizzbuzz x)
(recur (+ x 1))))



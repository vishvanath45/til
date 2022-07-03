
(defn hello-world
([name]
(prn (str "Hello " name)))
([]
(prn ("Hello World"))))
 
(defn -main
[& args]
(let [name (read-line)]
(hello-world name)))


(-main)

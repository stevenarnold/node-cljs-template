(ns cljs-app.macros)

(defmacro new-obj
  "Gets around 'new' requiring a symbol, also runs cljs->js on its args"
  [obj & args]
  (let [arg-forms (map (fn [arg] `(cljs.core/clj->js ~arg)) args)]
    `(let [obj# ~obj]
       (new obj# ~@arg-forms))))
 
(defmacro when-node
  [& body]
  `(when (= "node" (some-> ~'(this-as x x)
                           (aget "process")
                           (aget "title")))
     ~@body))


(defmacro fn-js
  [& body]
  `(fn [& args#]
     (~'cljs.core/clj->js
      (apply (fn ~@body)
             (map ~'cljs.core/js->clj args#)))))

(defmacro defn-js
  "Creates a function that's meant for a javascript boundary.
   Will convert data structures in and out. Experimental"
  [name & body]
  `(def ~name
     (fn-js ~@body)))

(defmacro dbg[x] `(let [x# ~x] (println '~x "=" x#) x#))

(defmacro ng-fn
  "Wrapper for generating angular implementation DI-syntax.
   Turns (ng-fn [$http]) into ['$http', function($http){}]"
  [args & body]
  (let [forms (concat (map str args)
                      [`(fn ~args ~@body)])]
    `(cljs.core/array ~@forms)))

(defmacro obj
  "Helper to create javascript objects via keyword keys."
  [& key-values]
  (let [obj-def (apply concat (map #(list (name (first %)) (last %))
                                   (partition 2 key-values)))]
    `(cljs.core/js-obj ~@obj-def)))

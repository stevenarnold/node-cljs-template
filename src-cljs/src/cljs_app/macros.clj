(ns cljs-app.macros)

(defmacro new-obj
  "Gets around 'new' requiring a symbol, also runs cljs->js on its args"
  [obj & args]
  (let [arg-forms (map (fn [arg] `(cljs.core/clj->js ~arg)) args)]
    `(let [obj# ~obj]
       (new obj# ~@arg-forms))))
 


(ns cljs-app.core
  (:require [cljs.nodejs :as node])
  (:require-macros [cljs-app.macros :as ms :refer [new-obj]]))

(def gui (node/require "nw.gui"))

(defn ->Tray
  [menu opts]
  (let [t (new-obj (.-Tray gui) opts)]
    (aset t "menu" menu)
    t))

(defn ->MenuItem
  [opts]
  (new-obj (.-MenuItem gui) opts))

(defn ->Menu [] (new-obj (.-Menu gui)))

(defn system-tray
  [title & menu-items]
  (->Tray (reduce (fn [menu item]
                    (.append menu (->MenuItem item))
                    menu)
                  (->Menu)
                  menu-items)
        {:title title}))

(system-tray
 "Nodify"
 {:type "checkbox" :label "box1"}
 {:label "Exit" :click #(.quit (.-App gui))})

(.log js/console "WATT") 
 

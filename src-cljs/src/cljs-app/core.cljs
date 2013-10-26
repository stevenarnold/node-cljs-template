(ns cljs-app.core
  (:require [cljs.nodejs :as node]))

(def gui (node/require "nw.gui"))

(def Tray (.-Tray gui))

(def tray (new Tray (clj->js {:title "Tray"})))

(def Menu (.-Menu gui))
(def menu (new Menu))
 
(def MenuItem (.-MenuItem gui))
(. menu (append (new MenuItem (clj->js { :type "checkbox" :label "box1"}))))

(aset tray "menu" menu)
 
(.log js/console "WATT") 
 

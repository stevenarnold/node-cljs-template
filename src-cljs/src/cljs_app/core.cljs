(ns cljs-app.core
  (:require cljs-app.node-bits)
  (:require-macros [cljs-app.macros :refer [defn-js ng-fn]]))


(defn log [& args]
  (js/console.log args))


(doto (js/angular.module "myApp" (array))
  (.controller "Test" (ng-fn [$scope] (aset $scope "Hello" "World"))))


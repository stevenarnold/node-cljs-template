(defproject node-cljs-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 ]

  :plugins [[lein-cljsbuild "0.3.4"]]
  :cljsbuild {:builds [{;; The path to the top-level ClojureScript source directory:
                        :source-paths ["src"]
                        :target :nodejs
                        ;; The standard ClojureScript compiler options:
                        ;; (See the ClojureScript compiler documentation for details.)
                        :compiler {:output-to "../src/cljs-app.js"  ; default: target/cljsbuild-main.js
                                   :optimizations :simple
                                   :pretty-print true}}]})

(defproject fred "0.1.0-SNAPSHOT"
  :min-lein-version "2.7.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.clojure/core.async "0.4.474"]]

  :plugins [[lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]
            [lein-doo "0.1.10"]
            [lein-figwheel "0.5.15"]]
  :hooks [leiningen.cljsbuild]

  :doo {:build "test" ; "dooit"
        :paths {:karma   "./node_modules/karma/bin/karma"
                :phantom "./node_modules/phantomjs/bin/phantomjs"}}

  :source-paths ["src"]
  :cljsbuild {:builds
              [{:id           "dev"
                :source-paths ["src"]
                ;; The presence of a :figwheel configuration here will cause figwheel to inject the
                ;; figwheel client into your build
                :figwheel     {:on-jsload "fred.core/on-js-reload"
                               ;; :open-urls will pop open your application in the default browser once
                               ;; Figwheel has started and compiled your application.  Comment this out
                               ;; once it no longer serves you.
                               :open-urls ["http://localhost:3449/index.html"]}
                :compiler     {:main                 fred.core
                               ;:libs                 ["resources/public/dino.js"] ; works
                               ;:libs                 ["resources/public"] ; also works
                               ;:libs                 ["resources"] ; works a 3rd way (why?)
                               ;:libs <missing completely> => compiler error

                               :externs              ["dino-externs.js"]
                               :foreign-libs         [{:file     "dino.js"
                                                       :provides ["dno"]}]

                               :asset-path           "js/compiled/out"
                               :output-to            "resources/public/js/compiled/fred.js"
                               :output-dir           "resources/public/js/compiled/out"
                               :source-map-timestamp true
                               ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                               ;; https://github.com/binaryage/cljs-devtools
                               :preloads             [devtools.preload]}}

               {:id           "test"
                :source-paths ["src"]
                :figwheel {:repl false}
                :compiler     {:main                 tst.fred.doorunner
                               :externs              ["dino-externs.js"]
                               :foreign-libs         [{:file     "dino.js"
                                                       :provides ["dno"]}]
                               :optimizations        :none
                               :output-to            "resources/public/js/compiled/wilma.js"

                               ; CRASHES if VVV these 2 lines are present VVV
                               ;:asset-path           "js/compiled/tstout" ; DO NOT INCLUDE
                               ;:output-dir           "resources/public/js/compiled/tstout" ; DO NOT INCLUDE
                               ; CRASHES if ^^^ these 2 lines are present ^^^

                               :source-map-timestamp true
                               ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                               ;; https://github.com/binaryage/cljs-devtools
                               :preloads             [devtools.preload]
                               }}
               ]}

  :profiles {:dev {:dependencies  [[binaryage/devtools "0.9.9"]
                                   [figwheel-sidecar "0.5.15"]
                                   [com.cemerick/piggieback "0.2.2"]]
                   ;; need to add dev source path here to get user.clj loaded
                   :source-paths  ["src" "dev"]
                   ;; for CIDER
                   ;; :plugins [[cider/cider-nrepl "0.12.0"]]
                   :repl-options  {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   ;; need to add the compliled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}}

  ;:figwheel {:repl false}
  :jvm-opts ["-Xmx1g"]
  )

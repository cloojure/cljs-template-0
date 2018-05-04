(defproject flintstones "0.1.0-SNAPSHOT"
  :min-lein-version "2.7.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.clojure/core.async "0.4.474"]
                 [tupelo "0.9.76"]]
  :plugins [[lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]
            [lein-figwheel "0.5.15"]
            [lein-doo "0.1.10"]]

  :doo {:karma {:config {"plugins"       ["karma-junit-reporter"]
                         "reporters"     ["progress" "junit"]
                         "junitReporter" {"outputDir" "target/test-results"}}}
        :paths {:karma   "node_modules/karma/bin/karma"
                :phantom "node_modules/phantomjs/bin/phantomjs" }}
  :source-paths ["src"]
  :cljsbuild {:builds
              [{:id           "dev"
                :source-paths ["src"]
                ;; The presence of a :figwheel configuration here will cause figwheel to inject the
                ;; figwheel client into your build
                :figwheel     {:on-jsload "flintstones.core/on-js-reload"
                               ;; :open-urls will pop open your application in the default browser once
                               ;; Figwheel has started and compiled your application.  Comment this out
                               ;; once it no longer serves you.
                               :open-urls ["http://localhost:3449/index.html"]}
                :compiler     {:main                 flintstones.core
                               :optimizations        :none
                               :libs                 ["resources/public/libs"] ; recursive includes all children

                               :foreign-libs         [{:file     "dino.js"
                                                       :provides ["dinoPhony"]}]
                               :externs              ["dino-externs.js"]

                               :output-to            "resources/public/js/compiled/flintstones.js"
                               :output-dir           "resources/public/js/compiled/flintstones-dev"
                               :asset-path           "js/compiled/flintstones-dev" ; rel to figwheel default of `resources/public`
                               ;                     ^^^^^ must match :output-dir
                               :source-map-timestamp true
                               ; To console.log CLJS data-structures make sure you enable devtools in Chrome
                               ; https://github.com/binaryage/cljs-devtools
                               ; :preloads             [devtools.preload]
                               }}

               {:id           "test"
                :source-paths ["src" "test"]
                :compiler     {:main                 tst.flintstones.doorunner
                               :optimizations        :none ; :advanced
                               :libs                 ["resources/public/libs"] ; recursive includes all children

                               :foreign-libs         [{:file     "dino.js"
                                                       :provides ["dinoPhony"]}]
                               :externs              ["dino-externs.js"]

                               :output-to            "resources/public/js/compiled/bedrock.js"
                               :output-dir           "resources/public/js/compiled/bedrock-tst"
                               ;:asset-path           "js/compiled/bedrock-tst" ; rel to figwheel default of `resources/public`

                               :source-map-timestamp true}}]}

  :profiles {:dev {:dependencies  [[figwheel-sidecar "0.5.15"]]
                   :source-paths  ["src" "dev"]    ; need to add dev source path here to get user.clj loaded
                   ;; need to add the compliled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     "out"
                                                     :target-path]
                   }}

  :jvm-opts ["-Xmx1g"] ; Java 8
 ;:jvm-opts ["-Xmx1g" "--add-modules" "java.xml.bind"]  ; needed for Java 9/Java 10
)

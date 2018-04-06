(ns tst.fred.doorunner
  (:require
    [tst.fred.core]
    [doo.runner :refer-macros [doo-tests]] ))

(enable-console-print!)
(println "tests - before")
(doo-tests
  'tst.fred.core
)
(println "tests - after")



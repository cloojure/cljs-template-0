(ns tst.fred.doorunner
  (:require
    [tst.fred.dino]
    [doo.runner :refer-macros [doo-tests]] ))

(enable-console-print!)
(println "tests - before")
(doo-tests
  'tst.fred.dino
)
(println "tests - after")



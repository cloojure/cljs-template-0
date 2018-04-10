(ns tst.fred.doorunner
  (:require
    [tst.fred.dino]
    [tst.fred.wilma]
    [doo.runner :refer-macros [doo-tests]] ))

(enable-console-print!)
(println "tests - before")
(doo-tests
  'tst.fred.dino
  'tst.fred.wilma
)
(println "tests - after")



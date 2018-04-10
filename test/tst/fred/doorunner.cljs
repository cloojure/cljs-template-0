(ns tst.fred.doorunner
  (:require
    [tst.fred.dino]
    [tst.fred.wilma]
    [tst.fred.pebbles]
    [doo.runner :refer-macros [doo-tests]] ))
(enable-console-print!)
(println "doorunner - beginning")

(doo-tests
  'tst.fred.dino
  'tst.fred.wilma
)
(println "doorunner - end")

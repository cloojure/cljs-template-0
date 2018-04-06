// goog.provide('dno');
// dno.globalObject = { a: 1, b: 2, c: 3 };

globalObject = {a: 1, b: 2, c: 3};

makeDino = function () {
  var dino = {};
  dino.desc = "blue dino-dog";
  dino.says = function () {
    return "Ruff-Ruff-Ruff-Ruff-Ruff!";
  };
  return dino;
}

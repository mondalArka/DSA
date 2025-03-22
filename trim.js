let obj1 = {
  a1: "      hello a1    ",
  aBool:false,
  a2: "",
  a3: ["   hello a3  ", ["hello from another a3          "]],
  a4: [[["        hello a4   "], { a41: "   hello a41    ", a42: { a441: "   hello a441   " } }], "      hello outside a4  "],
  a5: {
    a51: [[[["        hello a4   "], { a41: "   hello a41    ", a42: { a441: "   hello a441   " } }], "      hello outside a4  "]],
    a52: {
      a551: "   hello a52  ",
      a552: {
        a5551: " hello a5551      ",
        a5522: [["  hello a5552     "]]
      }
    }
  },
  a7:1234
}
console.log(obj1,"original");
console.log("----------------------------------");


const trim = (obj) => {
  switch (Array.isArray(obj)) {
    case true: {
      for (let i = 0; i < obj.length; i++) {
        if (typeof obj[i] == "string") obj[i] = obj[i].trim();
        else if (typeof obj[i] != "boolean" && typeof obj[i] != "number") trim(obj[i]);
      }
      break;
    }
    case false: {
      Object.entries(obj).forEach(([key, val]) => {
        if (typeof val == "string")
          obj[key] = val.trim();

        else if (typeof val != "boolean" && typeof val != "number") trim(obj[key]);
      })
      break;
    }
    default: console.log("error"); //******************replace it with error */
  }
}
trim(obj1);
console.log(JSON.stringify(obj1, null, 2));
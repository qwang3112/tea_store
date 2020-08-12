###1、首页数据

```
GET /tea/index
```

参数

```json
无
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    categories: [
      {
        name: "绿茶",
        type: 1
      }
    ],
    teas: [
      {
        id: 1,
        title: "绿茶1",
        price: "100.00",
        desc: "绿茶",
        tag: [
          {
            name: "好喝"
          },
          {
            name: "苦"
          }
        ],
        thumb: "../static/greentea.jpg"
      }
    ]
  }
}
```

###2、根据类型查询茶叶

```
GET /tea/findByCategoryType
```

参数

```json
categoryType: 1
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: [
    {
      id: 1,
        title: "绿茶1",
        price: "100.00",
        desc: "绿茶",
        tag: [
          {
            name: "好喝"
          },
          {
            name: "苦"
          }
        ],
        thumb: "../static/greentea.jpg"
    }
  ]
}
```

###3、查询茶叶规格

```
GET /tea/findSpecsByTeaId
```

参数

```json
teaId: 1
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    goods: {
      picture: "../static/greentea.jpg"
    },
    sku: {
      tree: [
        {
          k: "规格",
          v: [
            {
              id: 1,
              name: "1斤装",
              imgUrl: "../static/greentea.jpg",
              previewImgUrl: "../static/greentea.jpg"
            },
            {
              id: 2,
              name: "2斤装",
              imgUrl: "../static/greentea.jpg",
              previewImgUrl: "../static/greentea.jpg"
            }
          ],
          k_s: "s1"
        }
      ],
      list: [
        {
          s1: 1,
          price: 10000,
          stock_num: 1
        },
        {
          s1: 2,
          price: 20000,
          stock_num: 1
        }
      ],
      price: "100.00",
      stock_num: 2,
      none_sku: false,
      hide_stock: false
    }
  }
}
```

###4、查询地址

```
GET /address/list
```

参数

```json
无
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: [
    {
      areaCode: "440303",
      id: 21,
      name: "张三",
      tel: "13678787878",
      address: "广东省深圳市罗湖区科技路123号456室"
    }
  ]
}
```

### 5、创建地址

```
POST /address/create
```

参数

```json
{
  name: "张三"
  tel: "13678900987"
  country: ""
  province: "北京市"
  city: "北京市"
  county: "东城区"
  areaCode: "110101"
  postalCode: ""
  addressDetail: "168号306室"
  isDefault: false
}
```

返回

```json
{
    code: 0,
    msg: "成功",
    data: null
}
```

### 6、修改地址

```
PUT /address/update
```

参数

```json
{
  id: 27
  name: "张三"
  tel: "13678900987"
  addressDetail: "168号306室"
  areaCode: "110101"
  province: "北京市"
  city: "北京市"
  county: "东城区"
}
```

返回

```json
{
    code: 0,
    msg: "成功",
    data: null
}
```

###7、创建订单

```
POST /order/create
```

参数

```json
{
  name: "张三"
  tel: "13678787878"
  address: "广东省深圳市罗湖区科技路123号456室"
  specsId: 1
  quantity: 1
}
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
      orderId: "1586254006069813075"
  }
}
```

###8、订单详情

```
GET /order/detail
```

参数

```json
orderId: "1586253884545138376"
```

返回

```json
{
  code: 0,
  msg: "成功",
  data: {
    orderId: "1586253884545138376",
    buyerName: "张三",
    teaName: "绿茶1",
    payStatus: 0,
    freight: 10,
    tel: "13678787878",
    address: "广东省深圳市罗湖区科技路123号456室",
    num: 1,
    specs: "1斤装",
    price: "100.00",
    icon: "../static/greentea.jpg",
    amount: 110
  }
}
```

###9、支付订单

```
PUT /order/pay
```

参数

```json
orderId: "1586253884545138376"
```

返回

```json
{
  code: 0
  msg: "成功"
  data: {
      orderId: "1586253884545138376"
  }
}
```



# MongoDB Commands

Using mongosh






## Installation

Install/uninstall for mac os

```bash
  xcode-select --install
  brew tap mongodb/brew
  brew update
  brew install mongodb-community@7.0

  brew services start mongodb/brew/mongodb-community
  brew services stop mongodb/brew/mongodb-community
  brew services restart mongodb/brew/mongodb-community

  mongosh

  
  brew uninstall mongodb-community 
  brew uninstall mongodb-database-tools
  brew uninstall mongosh
  brew untap mongodb/brew

  sudo rm -rf /tmp/mongodb-27017.sock  
```
    
## Commands execution 



```bash
test> show dbs 
admin    40.00 KiB
config  108.00 KiB
local    72.00 KiB
myDB      8.00 KiB

Insert : db.myDB.insert({id:1,name:"Rakesh",city:"Jabalpur" })


db.customer.find()
[
  {
    _id: ObjectId('65b629be5562a2a0d5f788b8'),
    id: 1,
    name: 'Rakesh',
    city: 'Jabalpur'
  },
  {
    _id: ObjectId('65b62a7b5562a2a0d5f788b9'),
    id: 2,
    name: 'Prakash',
    city: 'Hyderabad'
  },
  {
    _id: ObjectId('65b62ac4b172d192ac4b28e4'),
    id: 3,
    name: 'Ramesh',
    city: 'Surat',
    state: 'Gujrat'
  }
]

myDB> db.customer.find().pretty()
[
  {
    _id: ObjectId('65b629be5562a2a0d5f788b8'),
    id: 1,
    name: 'Rakesh',
    city: 'Jabalpur'
  },
  {
    _id: ObjectId('65b62a7b5562a2a0d5f788b9'),
    id: 2,
    name: 'Prakash',
    city: 'Hyderabad'
  },
  {
    _id: ObjectId('65b62ac4b172d192ac4b28e4'),
    id: 3,
    name: 'Ramesh',
    city: 'Surat',
    state: 'Gujrat'
  }
]
db.customer.find({id:1}).pretty()
[
  {
    _id: ObjectId('65b629be5562a2a0d5f788b8'),
    id: 1,
    name: 'Rakesh',
    city: 'Jabalpur'
  }
]

db.customer.deleteOne({id:4})
{ acknowledged: true, deletedCount: 1 }

myDB> db.customer.insertMany([{id:04,name:"Videsh"},{id:5,name:"Brijest",city:"Mohali"}],[{id:6,name:"Kumar"},{id:50,name:"Binod"}])
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('65b633fe5562a2a0d5f788bd'),
    '1': ObjectId('65b633fe5562a2a0d5f788be')
  }
}
```

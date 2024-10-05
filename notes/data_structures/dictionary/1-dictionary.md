You create a dictionary with curly braces, followed by a key and a value. Just like a json object. see below
```python
capitals = {'Ghana': 'Accra', 'Nigeria': 'Abuja', 'Cameroon': 'Yaounde'}
```

### Dictionary Operators
1. [] - capitals['Ghana'] - Returns the value associated with the key Ghana, otherwise it is an error
2. in - Ghana in capitals - Returns True if the key Ghana is in the dictionary, False otherwise
3. del - del capitals['Ghana'] - Removes the entry Ghana from the dictionary


### Dictionary Methods
1. keys - capitals.keys() - Returns the keys of the dictionary in a dict_keys object 
2. values - capitals.values() - Returns the values of the dictionary in a dict_values object
3. items - capitals.items() - Returns the key-value pairs in a dict_items object
4. get - capitals.get('Ghana') - Returns the value associated with the key Ghana, None if otherwise
5. get - capitals.get('Ghana' 'Not Found') - Returns the value associated with the key Ghana, Not found if otherwise
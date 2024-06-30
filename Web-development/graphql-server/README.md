To set up a GraphQL server using only the terminal, you can follow these steps:

1. **Open your terminal** and navigate to the directory where you want to create your project.

2. **Create a new directory for your project**:
```bash
mkdir graphql-server
```

3. **Change into the new directory**:
```bash
cd graphql-server
```

4. **Initialize a new Node.js project**:
```bash
npm init -y
```

5. **Install the required dependencies**:
```bash
npm install express express-graphql graphql
```

6. **Create a new file called `server.js`**:
```bash
touch server.js
```

7. **Open the `server.js` file in a text editor** and add the following code:

```javascript
const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');

// Construct a schema, using GraphQL schema language
const schema = buildSchema(`
  type Query {
    hello: String
  }
`);

// The root provides a resolver function for each API endpoint
const root = {
  hello: () => {
    return 'Hello world!';
  },
};

const app = express();

// Redirect the root URL to the GraphQL endpoint
app.get('/', (req, res) => {
  res.redirect('/graphql');
});

app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: root,
  graphiql: true,
}));

app.listen(4000, () => console.log('Now browse to localhost:4000/graphql'));

```

8. **Save the `server.js` file** and return to the terminal.

9. **Start the server**:
```bash
node server.js
```

10. **Open your web browser** and go to `http://localhost:4000/graphql`. You should see the GraphiQL interface where you can test your GraphQL queries.

11. **Run the following query**:
```graphql
{
  hello
}
```

You should see the response:
```json
{
  "data": {
    "hello": "Hello world!"
  }
}
```

const express = require('express');
const app = express();

// Create a new user
app.post('/users', (req, res) => {
  try {
    const { name, email } = req.body;
    // Add logic to create a new user
    const user = { id: Date.now(), name, email };
    users.push(user);
    res.send({ message: 'User created successfully' });
  } catch (error) {
    res.status(500).send({ message: 'Error creating user' });
  }
});

// Get all users
app.get('/users', (req, res) => {
  res.send({ users: users });
});

// Get a specific user
app.get('/users/:id', (req, res) => {
  const id = req.params.id;
  const user = users.find((user) => user.id === parseInt(id));
  if (!user) {
    res.status(404).send({ message: 'User not found' });
  } else {
    res.send({ user });
  }
});

// Update a user
app.put('/users/:id', (req, res) => {
  try {
    const id = req.params.id;
    const { name, email } = req.body;
    const user = users.find((user) => user.id === parseInt(id));
    if (!user) {
      res.status(404).send({ message: 'User not found' });
    } else {
      user.name = name;
      user.email = email;
      res.send({ message: 'User updated successfully' });
    }
  } catch (error) {
    res.status(500).send({ message: 'Error updating user' });
  }
});

// Delete a user
app.delete('/users/:id', (req, res) => {
  try {
    const id = req.params.id;
    const user = users.find((user) => user.id === parseInt(id));
    if (!user) {
      res.status(404).send({ message: 'User not found' });
    } else {
      users.splice(users.indexOf(user), 1);
      res.send({ message: 'User deleted successfully' });
    }
  } catch (error) {
    res.status(500).send({ message: 'Error deleting user' });
  }
});

// Start the server
app.listen(3000, () => {
  console.log('Server started on port 3000');
});
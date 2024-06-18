const express = require('express');
const bodyParser = require('body-parser');
const { Pool } = require('pg');

const app = express();
app.use(bodyParser.json());

const pool = new Pool({
  user: 'myuser',
  host: 'localhost',
  database: 'mydatabase',
  password: 'mypassword',
  port: 5432,
});

app.get('/api/data', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM mytable');
    res.json(result.rows);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Failed to retrieve data' });
  }
});

app.post('/api/data', async (req, res) => {
  try {
    const { name, age } = req.body;
    const result = await pool.query(
      'INSERT INTO mytable (name, age) VALUES ($1, $2) RETURNING *',
      [name, age]
    );
    res.json(result.rows[0]);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Failed to create data' });
  }
});

app.put('/api/data/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const { name, age } = req.body;
    const result = await pool.query(
      'UPDATE mytable SET name = $1, age = $2 WHERE id = $3 RETURNING *',
      [name, age, id]
    );
    res.json(result.rows[0]);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Failed to update data' });
  }
});

app.delete('/api/data/:id', async (req, res) => {
  try {
    const { id } = req.params;
    await pool.query('DELETE FROM mytable WHERE id = $1', [id]);
    res.json({ message: 'Data deleted successfully' });
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Failed to delete data' });
  }
});

app.listen(3001, () => {
  console.log('Server started on port 3001');
});
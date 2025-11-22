const express = require('express');
const pkg = require('../package.json');

const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
  res.send(`CI Monitoring Demo 🚀 - Version: ${pkg.version}`);
});

app.listen(PORT, () => {
  console.log(`App listening on port ${PORT}. Version: ${pkg.version}`);
});

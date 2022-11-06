import './App.css';
import React, {useState,useEffect} from 'react';
import axios from 'axios';


function App() {

  const [file, setFile] = useState()
  const [users,setUser]=useState([])
  useEffect(()=>{
    fetch("http://localhost:8080/storage/filedb").then((result)=>{
      result.json().then((resp)=>{
        setUser(resp)
      })
    })
  },[])

  function handleChange(event) {
    setFile(event.target.files[0])
  }
  
  function handleSubmit(event) {
    event.preventDefault()
    const url = 'http://localhost:8080/storage/uploadFile';
    const formData = new FormData();
    formData.append('file', file);
    //formData.append('fileName', file.name);
    const config = {
      headers: {
        'content-type': 'multipart/form-data',
      },
    };
    axios.post(url, formData).then((response) => {
      console.log(response.data);
    });

  }

  return (
    <div className="App">
        <form onSubmit={handleSubmit}>
          <h1>PDF to Amazon S3</h1>
          <input type="file" onChange={handleChange}/>
          <button type="submit">Upload</button>
        </form>

        <h1>GET YOUR FILES HERE </h1>
  
      <table>
       <tbody>
       
       <tr>
       
          <td>ID</td>
          <td>FILE URL</td>
          
          
        </tr>
        {
          users.map((item,i)=>
            <tr key={i}>
            <td>{item.id}</td>
          <td><text style={{color: 'blue'}}
      onClick={() => window.open(item.fileurl)}>
  {item.fileurl}
</text></td>
          
         
          </tr>
          )
        }
       </tbody>
       </table>
    </div>

  );
}

export default App;
import React, { useState } from 'react'
import axios from 'axios';
const QrForm=function QrForm({OnQrGenerated}){
    const [InputTextQr,SetInputTextQr]=useState('');

    const generateQr=async()=>{
        try {
          const response=await axios.post("http://localhost:8080/v1/QrGen",{
            url:InputTextQr
          })
            const QrPath={
              path:response.data.path
            }
            console.log("path at form"+QrPath.path);
            OnQrGenerated(QrPath)
        } catch (error) {
          console.error(error);
        }
      }
    
    return(
        <div className="container">
        <h1 className="title">QR GENERATOR</h1>
        <input 
          className="inputText"
          type="text"
          value={InputTextQr}
          onChange={(e) => {
            SetInputTextQr(e.target.value);
          }}
        />
        <button className="QrGen" type="submit" onClick={generateQr}>Generate QR</button>
      </div>
    )
}
export default QrForm
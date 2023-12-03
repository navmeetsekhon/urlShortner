import React, { useState } from "react";
import axios from "axios";
import "../css/urlForm.css";

export default function UrlForm({ onUrlShortened }) {
  const [originalUrl, setOriginalUrl] = useState("");

  const shortenUrl = async () => {
    try {
      const response = await axios.post("http://localhost:8080/v1/createUrl", {
        url: originalUrl,
      });

      const Url = {
        longUrl: originalUrl,
        ShortKey: response.data.key,
      };
      onUrlShortened(Url);
    } catch (error) {
      console.error("Error shortening url api" + error);
    }
  };
  return (
    <>
      <div className="container">
        <h1 className="title">URL SHORTNER</h1>
        <input
          className="inputUrl"
          type="text"
          value={originalUrl}
          onChange={(e) => {
            setOriginalUrl(e.target.value);
          }}
        />
        <button className="UrlShortner" type="submit" onClick={shortenUrl}>
          Generate url
        </button>
      </div>
    </>
  );
}

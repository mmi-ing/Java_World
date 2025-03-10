"use client"
import Image from "next/image";
import styles from "./page.module.css";
import { useEffect, useState } from "react";
import axios from "axios";
import ItemList from "@/component/ItemList";
import { Divider } from "@mui/material";

export default function Home() {
  const api_url = "/api/v1/products.json?brand=maybelline";
  const [list, setList] = useState([]);

  function callApi(){// async communication activates
    //axios.get(api_url).then(function(res){});
    axios.get(api_url).then((data)=>{
      console.log(data);
      setList(data.data);
    });
  }

  useEffect(()=> {// 현재페이지가 읽혀질때 한번 호출함!
    callApi();
  }, []); //계속 호출되는 것을 막기 위함

  return (
    <div className={styles.page}>
      <div style={{width: '80%', margin: 'auto', paddingTop: '20px'}}>
        <h2>베스트 상품</h2>
        <Divider/> {/* 구분선 */}
        <ItemList list={list.slice(0,9)}/>
      
        <h2>신상품</h2>
        <Divider/> {/* 구분선 */}
        <ItemList list={list.slice(9)}/>
      </div>
    </div>
  );
}
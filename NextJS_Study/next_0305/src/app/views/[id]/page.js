
// export default function Page(props) {
//     return(
//         <div>
//             <h2>{props.params.id}</h2>
//         </div>
//     );
// }
"use client"
import axios from "axios";
import { useEffect, useState } from "react";
import Item from "@/component/Item";
import { useParams } from "next/navigation";

export default function Page() {
// export default function Page() {
    // const {id} = use(params);

    const params = useParams();
    const id = params.id;

    const api_url = `/api/v1/products/${id}.json`;
    const [vo, setVO] = useState({}); // 중괄호, 비어있는 객체는 json 객체겠구나, 배열일 경우도 생각

    // 비동기식 통신을 위한 함수
    function getData(){
        axios.get(api_url).then((res)=>{
          setVO(res.data);
        });
      }

      // 현재문서에서 id변수의 값이 변경될 때마다 서버 호출  
      useEffect(()=> {
        // 이렇게만 적어도 id가 비어있지 않다면을 뜻함
        if(id && id > 0){
          getData();
        }
      }, [id]); //id 값이 바뀌면 useEffect를 다시 실행, 바뀌지 않으면 실행X

    return(
        <div>
            {/* <img src={vo.image_link} alt={vo.name}/> */}
            {/* <h2>{id}</h2> */}
            <Item item={vo}/>
        </div>
    )
}
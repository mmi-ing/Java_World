import { Grid2 } from "@mui/material";
import styles from "./css/itemList.module.css";
import Link from "next/link";

export default function ItemList({list}) { // 1. 반드시 list을 받아야 한다. ? list 명시
    return(
        <div>
            {/* 2. 통으로 받아서 props.list.length로 하는 게 아니라
                   딱 list를 받기 때문에 list.length로 하면 된다. 
            <h2>{list.length}</h2>*/}
            <Grid2 container>
                {
                    list.map((item) => (
                        <Grid2 item size={{xs:3}} key={item.id}>
                            <Link href="/views/[id]" as={'/views/'+item.id}>
                                <div className={styles.wrap}>
                                    <img className={styles.img_item} src={item.image_link} alt={item.name}/>
                                    <div className={styles.title_item}><strong>{item.name}</strong></div>
                                    <span className={styles.txt_info}>{item.category} &nbsp; {item.product_type}</span>
                                    <div className={styles.num_price}><strong>${item.price}</strong></div>
                                </div>
                            </Link>
                        </Grid2>
                    ))
                }
            </Grid2>
        </div>
    );
}
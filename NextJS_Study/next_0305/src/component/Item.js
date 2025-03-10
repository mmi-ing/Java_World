import { Button } from '@mui/material';
import styles from './css/Item.module.css';

export default function Itme({item}) {
    const { id, name, image_link, price, description, updated_at, category, product_type, product_link} = item;
    // 받은 item 이름이 위의 이름으로 다 저장되어서 그 이름으로 사용
    return(
        <>
            <div className={styles.wrap}>
                <div className={styles.img_item}>
                    <img src={image_link} alt={name}/>
                </div>
                <div className={styles.info_item}>
                    <strong className={styles.tit_item}>{name}</strong>
                    <strong className={styles.num_price}>{price}</strong>
                    <span className={styles.txt_info}>
                        {/* 카테고리가 비어 있지 않다면 */}
                        {category? `${category}/`: ""}
                        {product_type}
                    </span>
                    <Button variant='contained' color='error'>
                        구매하기
                    </Button>
                </div>
            </div>
            <div className={styles.disWrap}>
                <h3>Description</h3>
                <div style={{paddingBottom:20, fontSize:17}}>
                    {description}
                </div>
            </div>
        </>
    );    
}
"use client"
import { Box, Grid2 } from "@mui/material";
import { useState } from "react";

export default function Nav() {
    
    const navItem = ['Products', 'Color cosmetics', 'Skin cosmetics', 'About'];
    const [anchorEl, setAnchorEl] = useState(null);
    return (
        <nav id="header">
            <Grid2 container my={2}>
                {navItem.map( (item, idx)=>(
                    <Grid2 item key={idx} size={{xs:12, sm:3}}>
                        <Box bgcolor='primary.light' p={2}>{item}</Box>
                    </Grid2>

                )
                )}
            </Grid2>
        </nav>
  )
}

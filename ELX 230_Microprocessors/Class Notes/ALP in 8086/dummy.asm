;dosseg
.model small
.stack
.data
    value db 03bh 
    message db 'sum = $'   
.code
    
    main proc
        lea dx,message
        mov ah,09h
        int 21h
        
        mov ah,4ch
        int 21h
        
        main endp
    end main
    
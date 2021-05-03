;.dosseg
.model small
.stack
.data
    multiplicand db 12
    multiplier db 06

.code
    main proc
        .startup
        
        mov al,multiplicand
        mov bl,multiplier
        mul bl
        
        aam
        add ax,3030h
        
        mov dx,ax
        
        mov dh,al
        mov dl,ah
        mov ah,02h
        int 21h
        
        mov dl,dh
        int 21h
        
        mov ah,4ch
        int 21h
        
        main endp
    end main
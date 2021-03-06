;.dosseg
.model small
.data
    val1 db 99
    val2 db 64

.code
    main proc
        .startup
        
        mov ax,00;
        mov al,val1;
        sub al,val2;
        
        aam
        add ax,3030h;
                
        mov dl,ah
        mov dh,al
        mov ah,02h
        int 21h
        
        
        mov dl,dh
        mov ah,02h
        int 21h
        
        mov ah,4ch
        int 21h
        
        main endp
    end main
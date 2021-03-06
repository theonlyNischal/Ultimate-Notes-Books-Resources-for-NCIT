;.dosseg
.stack
.model small
.data
    array db 9,6,43,8,03
    greatest db 00
    count db 05

.code
    main proc
         
         .startup
         xor cx,cx
         mov cl,count
         
         mov si,offset array
         
         again:
            mov al,[si]
            cmp al,greatest
            jng skip
                mov greatest,al
            skip:
            inc si
            loop again
         
         
         mov al,greatest
         aam
         add ax,3030h
         
         mov dh,al
         mov dl,ah
         mov ah,02h
         int 21h
         
         mov dl,dh
         int 21h
         
         mov ah,4ch
         int 21h
         
         .exit
         
      
        
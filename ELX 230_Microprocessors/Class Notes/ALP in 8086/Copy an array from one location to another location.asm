;.dosseg
.model small
.stack
.data
    count db 05
    sourceArray db 11h, 22h, 33h, 44h, 55h
    destArray db 5 dp(?)
.code
    main proc
        .startup
        
        lea ax,sourceArray
        mov si,ax
        
        lea ax,destArray
        ;mov di,ax              ;;if this was done, the array would be copied to destArray(wherever the destArray is)
        mov di,4000h            ;;store that array in location starting from 4000h
        
        xor ax,ax
        
        xor cx,cx
        mov cl,count
        
        again:
            mov al,[si]
            mov [di],al
            inc si
            inc di
            loop again
        
        mov ah,4ch
        int 21h
        
        .exit
            
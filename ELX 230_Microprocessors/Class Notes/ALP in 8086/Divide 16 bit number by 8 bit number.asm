;.dosseg
.model small
.stack 100h
.data
    dividend dw 3432
    divisor db 43
.code
    main proc
        .startup
        
        mov ax,dividend
        div divisor          ;;quotient in al, remainder in ah
        
        mov dx,ax
        
        mov ah,4ch
        int 21h
        
        main endp
    end main
    